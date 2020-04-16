package sparql.queries;

import org.apache.jena.atlas.logging.LogCtl;

public class SparqlQueries {

    public static void main(String[] args) {
        LogCtl.setCmdLogging();
        java.awt.EventQueue.invokeLater(() -> {
            new AppWindow().setVisible(true);
        });
    }
    
}
