package task1.store;

import task1.util.Check;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<Check> checks;

    public History(final List<Check> checks) {
        this.checks = checks;
    }

    public History() {
        checks = new ArrayList<>();
    }
    public List<Check> getChecks() {
        return checks;
    }

    public void setReceipts(final List<Check> checks) {
        this.checks = checks;
    }
}
