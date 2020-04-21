package sqllite;

import java.io.File;
import java.util.List;
import sqllite.StoreSQL.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class StoreXML {
    private File target;

    public StoreXML(File target) {
        this.target = target;
    }
    public void save(List<Entry> list) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Entry.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    }
}
