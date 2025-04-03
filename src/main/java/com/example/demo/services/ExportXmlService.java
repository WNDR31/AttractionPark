package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class ExportXmlService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void exportToXml(String tableName) {
        try {
            // Crear documento XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element rootElement = doc.createElement("Datos");
            doc.appendChild(rootElement);

            // Ejecutar consulta SQL
            jdbcTemplate.query("SELECT * FROM " + tableName, (ResultSet rs) -> {
                while (rs.next()) {
                    Element row = doc.createElement("Fila");
                    rootElement.appendChild(row);

                    int columns = rs.getMetaData().getColumnCount();
                    for (int i = 1; i <= columns; i++) {
                        String columnName = rs.getMetaData().getColumnName(i);
                        String columnValue = rs.getString(i);

                        Element columnElement = doc.createElement(columnName);
                        columnElement.appendChild(doc.createTextNode(columnValue));
                        row.appendChild(columnElement);
                    }
                }
            });

            // Guardar XML en archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("data.xml"));
            transformer.transform(source, result);

            System.out.println("XML generado correctamente en 'data.xml'");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
