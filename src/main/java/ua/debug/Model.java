package ua.debug;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;


public class Model implements Serializable {

    private static final long serialVersionUID = -7328306836855874839L;

    private String _id;
    private String _value;
    private int _status;


    //
    // Constructors -------------------------------------------------------------------------------
    //
    public Model() {
        _id = UUID.randomUUID().toString();
        _value = RandomStringUtils.secure().next(10, "0123456789AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz");
        _status = RandomUtils.secure().randomInt(1, 10);
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


    public int getStatus() {
        return _status;
    }


    public void setStatus(int status) {
        this._status = status;
    }


    //
    // Generic Methods ----------------------------------------------------------------------------
    //
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this._id);
        hash = 29 * hash + Objects.hashCode(this._value);
        hash = 29 * hash + this._status;
        return hash;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Model other = (Model) obj;
        if (this._status != other._status) {
            return false;
        }
        if (!Objects.equals(this._id, other._id)) {
            return false;
        }
        return Objects.equals(this._value, other._value);
    }

}
