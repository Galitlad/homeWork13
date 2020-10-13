import java.sql.*;


public class DogsDataBase {

    private static final String USER_NAME = "1PdPHV74qc";
    private static final String DATABASE_NAME = "1PdPHV74qc";
    private static final String PASSWORD = "EFQWphoRBF";
    private static final String PORT = "3306";
    private static final String SERVER = "remotemysql.com";



    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://"+SERVER+":"+PORT, USER_NAME, PASSWORD);

//        createDogsTable(con);
//        insertDataIntoTable(con,"Laki", 2, "Terrier");
//        updateDataIntoTable(con,"Odem", 10, "Bulldog");
//        deleteThirdDogFromTable(con, "laki");
        getAllDogsNames(con);

        con.close();
    }


    private static void createDogsTable(Connection con) throws SQLException {

        String statementToExecute = "CREATE TABLE " + DATABASE_NAME + ".`dogs`(`name` VARCHAR(40) NOT NULL,`age` INT NOT NULL,`breed` VARCHAR(30) NOT NULL);";
        con.createStatement().execute(statementToExecute);

    }

    private static void insertDataIntoTable(Connection con, String name, int age, String breed) throws SQLException {
        Statement statement = con.createStatement();
        String statementToExecute = "INSERT INTO " + DATABASE_NAME + ".dogs (`name`, `age`, `breed`) VALUES ('" + name + "','" + age + "', '" + breed + "');";
        statement.execute(statementToExecute);
    }


    private static void updateDataIntoTable(Connection con, String name, int age, String breed) throws SQLException {
        Statement statement = con.createStatement();
        String statementToExecute = "UPDATE `" + DATABASE_NAME + "`.`dogs` SET `age` = '"+age+"'  WHERE `name` ='"+name+"' AND `breed` = '"+breed+"';";


        statement.executeUpdate(statementToExecute);
    }

    private static void deleteThirdDogFromTable(Connection con, String name) throws SQLException {
        String statementToExecute = "DELETE FROM `" + DATABASE_NAME + "`.`dogs` WHERE `name`='"+name+"';";
        con.createStatement().execute(statementToExecute);
    }

    private static void getAllDogsNames(Connection con) throws SQLException {

        String statementToExecute = "SELECT name FROM " + DATABASE_NAME + ".dogs;";
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(statementToExecute);
        while(resultSet.next()){
            String name = resultSet.getString("name");

            System.out.print(", name: " + name);
        }

        resultSet.close();
    }


}
