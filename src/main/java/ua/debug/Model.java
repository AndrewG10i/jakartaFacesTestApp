package ua.debug;

import java.io.Serializable;
import java.util.UUID;
import org.apache.commons.lang3.RandomStringUtils;


public class Model implements Serializable {

    private static final long serialVersionUID = -7328306836855874839L;

    private String _id;
    private String _value;


    //
    // Constructors -------------------------------------------------------------------------------
    //
    public Model() {
        _id = UUID.randomUUID().toString();
        _value = RandomStringUtils.random(10, "0123456789AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz");
    }


    public Model(String id) {
        _id = id;
    }


    //
    // Getters & Setters --------------------------------------------------------------------------
    //
    public String getId() {
        return _id;
    }


    public void setId(String id) {
        _id = id;
    }


    public String getValue() {
        return _value;
    }


    public void setValue(String value) {
        _value = value;
    }

}
