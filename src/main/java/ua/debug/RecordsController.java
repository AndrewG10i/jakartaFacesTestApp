package ua.debug;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import org.omnifaces.cdi.ViewScoped;


@Named
@ViewScoped
public class RecordsController implements Serializable {

    private static final long serialVersionUID = -1104773447854082205L;

    @Inject
    private AppDaoBean _appDaoBean;

    //
    // Methods ------------------------------------------------------------------------------------
    //
    public void generateMoreRecords() {
        _appDaoBean.generateModels();
    }


    //
    // Getters & Setters --------------------------------------------------------------------------
    //
    public List<Model> getRecords() {
        return _appDaoBean.getModelStore();
    }

}
