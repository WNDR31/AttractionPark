package com.example.demo.controller;

import com.example.demo.services.ExportXmlService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExportXmlController {

    private final ExportXmlService exportXmlService;

    public ExportXmlController(ExportXmlService exportXmlService) {
        this.exportXmlService = exportXmlService;
    }

    @GetMapping("/export")
    public String exportXml(@RequestParam String table) {
        exportXmlService.exportToXml(table);
        return "Exportación completada. Archivo generado: " + table + ".xml";
    }
}
