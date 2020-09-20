package persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLFileManager implements IFileManager{

	@Override
	public ArrayList<Object> readFile(String name) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeFile(String name,ArrayList<Object[]> list) {
		 String rootName = "Meta";
		DocumentBuilderFactory docBFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		Document document = null;
		TransformerFactory transFormerFactory = null;
		Transformer transformer = null;
		DOMSource domSource = null;
		try {
			docBuilder = docBFactory.newDocumentBuilder();
			document = docBuilder.newDocument();
			Element root = (Element) document.createElement(rootName);
			document.appendChild(root);
			transFormerFactory = TransformerFactory.newInstance();
			transformer = transFormerFactory.newTransformer();
			domSource = new DOMSource(document);
			StreamResult result = new StreamResult(new File(ConstantsPersistence.PATH_OUT+name+ConstantsPersistence.E_XML));
			transformer.transform(domSource, result);
			System.out.println("saved");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void writeNodes(Document document,Element root,String[] nameElements,
			String namePrincipalNode,ArrayList<Object[]> list) {
	}

	
}
