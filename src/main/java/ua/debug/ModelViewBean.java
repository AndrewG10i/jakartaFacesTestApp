package ua.debug;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;


@Named
@ViewScoped
public class ModelViewBean implements Serializable {

    private static final long serialVersionUID = 6400111954793903238L;

    @Inject
    private AppDaoBean _appDaoBean;

    private String _id;
    private Model _model;
    private Date _beanCreateTime;


    //
    // Methods ------------------------------------------------------------------------------------
    //
    @PostConstruct
    private void init() {
        _beanCreateTime = new Date();
    }


    @PreDestroy
    private void destroy() {
        System.out.println("Destroyed");
    }


    public void initModelR1() {
        if (_id == null || _id.trim().isEmpty()) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Model ID can not be blank", ""));
            context.getExternalContext().getFlash().setKeepMessages(true);
            Faces.redirect("/main.xhtml");
            return;
        }
        _model = new Model(_id);
    }


    public String deleteR1() {
        System.out.println(">> Deleting model with ID: " + _id);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Model ID: " + _id + " being deleted...", ""));
        context.getExternalContext().getFlash().setKeepMessages(true);
        _appDaoBean.daoDelete(_model);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Model ID: " + _model.getId() + " deleted", ""));
        Faces.redirect("/main.xhtml");
        return null;
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


    public Model getModel() {
        return _model;
    }


    public void setModel(Model model) {
        _model = model;
    }


    public Date getBeanCreateTime() {
        return _beanCreateTime;
    }


    public void setBeanCreateTime(Date beanCreateTime) {
        this._beanCreateTime = beanCreateTime;
    }

}
