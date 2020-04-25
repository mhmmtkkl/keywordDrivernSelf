package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {

    public String getData(String whichData){

        String path ="C:\\Users\\JuNiOr\\IdeaProjects\\KeyWordDriverSelfCreates\\src\\test\\resources\\config.properties";

        String result = null;

        try{
            InputStream input = new FileInputStream( path );
            Properties prop = new Properties(  );
            prop.load( input );
            result = prop.getProperty( whichData );

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
