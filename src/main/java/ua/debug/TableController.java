package ua.debug;

import jakarta.annotation.PostConstruct;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.omnifaces.cdi.ViewScoped;


@Named
@ViewScoped
public class TableController implements Serializable {

    private static final long serialVersionUID = -7696897678493753954L;

    private List<Integer> _statusFilter;
    private String _view;


    //
    // Constructors -------------------------------------------------------------------------------
    //
    public TableController() {
        _statusFilter = new ArrayList<>();
    }


    //
    // Methods ------------------------------------------------------------------------------------
    //
    @PostConstruct
    public void init() {
        setView("user");
        initDefaultFiltersForViewType();
    }


    private void initDefaultFiltersForViewType() {
        if ("admin".equals(getView())) {
            System.out.println(">>> Admin View");
            _statusFilter = IntStream.range(1, 10).boxed().collect(Collectors.toList());
        } else if ("user".equals(getView())) {
            System.out.println(">>> User View");
            _statusFilter = new ArrayList<>(List.of(1));
        }
    }


    public void viewNameChangeListener(AjaxBehaviorEvent event) {
        System.out.println(">> viewNameChangeListener() -> view updated to: " + getView());
        initDefaultFiltersForViewType();
    }


    //
    // Getters & Setters --------------------------------------------------------------------------
    //
    public List<Integer> getStatusFilter() {
        System.out.println(">>> getStatusFilter(): " + _statusFilter);
        return _statusFilter;
    }


    public void setStatusFilter(List<Integer> statusFilter) {
        System.out.println(">>> setStatusFilter(): " + statusFilter);
        _statusFilter = statusFilter;
    }


    public List<SelectItem> getStatusOptions() {
        return IntStream.range(1, 10)
                .mapToObj(status -> new SelectItem(status, String.valueOf(status)))
                .toList();
    }


    public String getView() {
        return _view;
    }


    public void setView(String view) {
        _view = view;
    }


    public List<SelectItem> getViewNameSI() {
        return List.of(
                new SelectItem("user", "User"),
                new SelectItem("admin", "Admin")
        );
    }


    public boolean filterFunction(Object value, Object filter, Locale locale) {
        System.out.println(">>> FilterFunction() >>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(">>> Value= " + value);
        System.out.println(">>> Filter= " + filter);
        return String.valueOf(filter).contains(String.valueOf(value));
    }

}
