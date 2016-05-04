package br.com.hsj.ep119.api.converter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

public class Converter {
	
    private Marshaller marshaller;
    
    private Unmarshaller unmarshaller;
    
    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }
    
    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }
    
    //Converts Object to XML file
    public void doMarshaling(String fileName, Object graph) throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
            marshaller.marshal(graph, new StreamResult(fos));
        } finally {
        	fos.close();
        }
    }
    
    //Converts XML to Java Object
    public Object doUnMarshaling(String fileName) throws IOException, URISyntaxException {
        FileInputStream fis = null;
        try {
        	URL resource = this.getClass().getResource(fileName);
        	File is = new File(resource.toURI());
        	
            fis = new FileInputStream(is);
            
            return unmarshaller.unmarshal(new StreamSource(fis));
        } finally {
        	fis.close();
        }
    }
} 