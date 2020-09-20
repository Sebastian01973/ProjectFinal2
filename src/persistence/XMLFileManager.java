package persistence;

import java.io.File;

import models.Diagnostic;
import models.ManagePatients;
import utilities.Utilities;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.xml.internal.ws.org.objectweb.asm.Attribute;

public class XMLFileManager implements IFileManager{

	@Override
	public ArrayList<Object> readFile(String name) throws IOException {
		return null;
	}

	@Override
//	public void writeFile(String name,ArrayList<Object[]> list) {
//		String rootName = "Meta";
//		DocumentBuilderFactory docBFactory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder docBuilder = null;
//		Document document = null;
//		TransformerFactory transFormerFactory = null;
//		Transformer transformer = null;
//		DOMSource domSource = null;
//		try {
//			docBuilder = docBFactory.newDocumentBuilder();
//			document = docBuilder.newDocument();
//			Element root = (Element) document.createElement(rootName);
//			document.appendChild(root);
//			transFormerFactory = TransformerFactory.newInstance();
//			transformer = transFormerFactory.newTransformer();
//			domSource = new DOMSource(document);
//			StreamResult result = new StreamResult(new File(ConstantsPersistence.PATH_OUT+name+ConstantsPersistence.E_XML));
//			transformer.transform(domSource, result);
//			System.out.println("saved");
//		} catch (ParserConfigurationException e) {
//			e.printStackTrace();
//		}catch (TransformerConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}catch (TransformerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public void writeFile(String name, ManagePatients managePatients) {
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
			
			Element firstRoot = document.createElement("Datas");
			root.appendChild(firstRoot);
			ArrayList<Diagnostic> list = managePatients.getDiagnosticList();
			for (Diagnostic diagnostic : list) {
				Element newElement = document.createElement("Case");
				Attr attr = document.createAttribute("number");
				attr.setValue(String.valueOf(diagnostic.getIdCases()));
				newElement.setAttributeNode(attr);
				Element element = document.createElement("Fecha_Diagnostico");
				element.setTextContent(Utilities.dateToString(diagnostic.getDateOfDiagnostic()));
				Element element1 = document.createElement("Fecha_Recuperacion");
				element1.setTextContent(Utilities.dateToString(diagnostic.getDateOfRecovered()));
				Element element2 = document.createElement("Fecha_Muerte");
				element2.setTextContent(Utilities.dateToString(diagnostic.getDateOfDeath()));
				Element element3 = document.createElement("Edad");
				element3.setTextContent(String.valueOf(diagnostic.getPatient().getAge()));
				Element element4 = document.createElement("Genero");
				element4.setTextContent(String.valueOf(diagnostic.getPatient().getGender()));
				Element element5 = document.createElement("Departamanento");
				element5.setTextContent(String.valueOf(diagnostic.getPatient().getLocation().getKeys()));
				Element element6 = document.createElement("Atencion");
				element6.setTextContent(String.valueOf(diagnostic.getPatient().getStates().getKey()));
				Element element7 = document.createElement("Estado_de_salud");
				element7.setTextContent(String.valueOf(diagnostic.getPatient().getHealthCondition().getKey()));
				newElement.appendChild(element);
				newElement.appendChild(element1);
				newElement.appendChild(element2);
				newElement.appendChild(element3);
				newElement.appendChild(element4);
				newElement.appendChild(element5);
				newElement.appendChild(element6);
				newElement.appendChild(element7);
				firstRoot.appendChild(newElement);
			}
			ArrayList<Object[]> listTable = managePatients.getDatasDepartaments();
			Element secondRoot = document.createElement("reportes");
			root.appendChild(secondRoot);
			int count = 1;
			for (Object[] objects : listTable) {
				Element elementDep = document.createElement("Reporte");
				Attr attr = document.createAttribute("Numero");
				attr.setValue(String.valueOf(count));
				elementDep.setAttributeNode(attr);
				Element telement = document.createElement("Departamento");
				telement.setTextContent(String.valueOf(objects[0]));
				Element telement1 = document.createElement("Casos_totales");
				telement1.setTextContent(String.valueOf(objects[1]));
				Element telement2 = document.createElement("Recuperados");
				telement2.setTextContent(String.valueOf(objects[2]));
				Element telement3 = document.createElement("Muertos");
				telement3.setTextContent(String.valueOf(objects[3]));
				elementDep.appendChild(telement);
				elementDep.appendChild(telement1);
				elementDep.appendChild(telement2);
				elementDep.appendChild(telement3);
				secondRoot.appendChild(elementDep);
				count++;
			}
			transFormerFactory = TransformerFactory.newInstance();
			transformer = transFormerFactory.newTransformer();
			domSource = new DOMSource(document);
			StreamResult result = new StreamResult(new File(ConstantsPersistence.PATH_OUT+"/xml/"+name+"."+ConstantsPersistence.E_XML));
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
	
	public void createElement(String name) {
		
	}

}
