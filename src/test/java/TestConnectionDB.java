import org.example.ispwprogect.utils.db.ConnectionDB;
import org.example.ispwprogect.utils.exception.SystemException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestConnectionDB {

    @Test
    void testGetConnection() throws SystemException {

        int value = 0;

        if (ConnectionDB.getConnection() != null) {
            value = 1;
        }

        Assertions.assertEquals(1, value);

    }

}
