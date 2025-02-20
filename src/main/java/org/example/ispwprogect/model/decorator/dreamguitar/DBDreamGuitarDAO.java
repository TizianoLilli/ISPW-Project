package org.example.ispwprogect.model.decorator.dreamguitar;

import org.example.ispwprogect.utils.db.ConnectionDB;
import org.example.ispwprogect.utils.enumeration.components.*;
import org.example.ispwprogect.utils.exception.SystemException;

import java.sql.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DBDreamGuitarDAO implements DreamGuitarDAO{

    @Override
    public void create(DreamGuitar guitarM) throws SystemException {
        String insertGuitarQuery = "INSERT INTO dream_guitar (id, price) VALUES (?, ?)";
        String insertComponentQuery = "INSERT INTO dream_guitar_components (guitar_id, component_name, component_value) VALUES (?, ?, ?)";

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement stmtGuitar = connection.prepareStatement(insertGuitarQuery)) {

            int guitarId = guitarM.id();
            if (guitarId == -1) {
                throw new SystemException("The guitar id is null");
            }

            stmtGuitar.setInt(1, guitarId);
            stmtGuitar.setDouble(2, guitarM.price());
            stmtGuitar.executeUpdate();

                // Salvataggio dei componenti
                try (PreparedStatement stmtComponent = connection.prepareStatement(insertComponentQuery)) {
                    for (Map.Entry<String, GenericType> entry : guitarM.allComponents().entrySet()) {
                        stmtComponent.setInt(1, guitarId);
                        stmtComponent.setString(2, entry.getKey());
                        // faccio un cast esplicito a enum per applicare .name()
                        stmtComponent.setString(3, ((Enum<?>)entry.getValue()).name());
                        stmtComponent.executeUpdate();
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public DreamGuitar read(int guitarId) throws SystemException {
        String selectGuitarQuery = "SELECT price FROM dream_guitar WHERE id = ?";
        String selectComponentsQuery = "SELECT component_name, component_value FROM dream_guitar_components WHERE guitar_id = ?";

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement stmtGuitar = connection.prepareStatement(selectGuitarQuery);
             PreparedStatement stmtComponents = connection.prepareStatement(selectComponentsQuery)) {

            stmtGuitar.setInt(1, guitarId);
            ResultSet rsGuitar = stmtGuitar.executeQuery();

            if (rsGuitar.next()) {
                double price = rsGuitar.getDouble("price");
                Map<String, GenericType> components = new HashMap<>();

                stmtComponents.setInt(1, guitarId);
                ResultSet rsComponents = stmtComponents.executeQuery();

                while (rsComponents.next()) {
                    String componentName = rsComponents.getString("component_name");
                    String componentValue = rsComponents.getString("component_value");

                    GenericType enumValue = null;
                    switch (componentName) {
                        case "pickup" -> enumValue = PickupType.valueOf(PickupType.class, componentValue);
                        case "strings" -> enumValue = StringsType.valueOf(StringsType.class, componentValue);
                        case "body" -> enumValue = BodyType.valueOf(BodyType.class, componentValue);
                        case "bridge" -> enumValue = BridgeType.valueOf(BridgeType.class, componentValue);
                        case "fretboard" -> enumValue = FretboardType.valueOf(FretboardType.class, componentValue);
                        case "neck&headstock" -> enumValue = NesType.valueOf(NesType.class, componentValue);
                    }
                    if (enumValue != null) {
                        components.put(componentName, enumValue);
                    }
                }

                return new DreamGuitar(price, guitarId, components);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int guitarId) throws SystemException {
        String deleteGuitarQuery = "DELETE FROM dream_guitar WHERE id = ?";

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(deleteGuitarQuery)) {

            stmt.setInt(1, guitarId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
