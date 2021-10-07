package connection;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private ConnectionFactory(){ throw new UnsupportedOperationException();}

    public static Connection getConnection(){
        //Objeto conexão irá receber uma conexão
        Connection connection = null;

        try(InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream("connection.properties")){

            //Definição do objeto que vai se conectar com o banco de dados MySQL
            Properties prop = new Properties();
            prop.load(input);

            String driver = prop.getProperty("jdbc.driver");
            String dataBaseAddress = prop.getProperty("db.address");
            String dataBaseName = prop.getProperty("db.name");
            String user = prop.getProperty("db.user.login");
            String password = prop.getProperty("db.user.password");

            //Construção da String de conexão
            StringBuilder sb = new StringBuilder("jdbc:")
                .append(driver).append("://")
                .append(dataBaseAddress).append("/")
                .append(dataBaseName);

            String connectionUrl = sb.toString();

            /**
             * Criar conexão usando DriverManager, passando como parametro aString de conexão,
             * usuário e senha do usuário.
             */
            try{
                connection = DriverManager.getConnection(connectionUrl, user, password);
                System.out.println("Conexão estabelecida com sucesso");
            }catch(SQLException e){
                System.out.println("Falha na conexão");
                throw new RuntimeException();
            }

        }catch (IOException e){
            System.out.println("Falha ao carregar arquivos de propiedades");
            e.printStackTrace();
        }
        return connection;
    }
}
