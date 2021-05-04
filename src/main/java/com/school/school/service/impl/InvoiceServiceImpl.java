package com.school.school.service.impl;

import com.school.school.dto.InvoiceDto;
import com.school.school.dto.OrderModel;
import com.school.school.dto.ResponseDto;
import com.school.school.dtoToEntityMapper.InvoiceDtoToEntityMapper;
import com.school.school.entity.Invoice;
import com.school.school.entity.Product;
import com.school.school.enums.ResponseEnum;
import com.school.school.repository.InvoiceDao;
import com.school.school.repository.ProductDao;
import com.school.school.service.InvoiceService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.jasperreports.JasperReportsUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Value("${invoice.logo.path}")
    private String logo_path;

    @Value("${invoice.template.path}")
    private String invoice_template;


    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ProductDao productDao;

    public File generateInvoiceFor(OrderModel order, Locale locale) throws IOException {

        File pdfFile = File.createTempFile("my-invoice", ".pdf");


        try(FileOutputStream pos = new FileOutputStream(pdfFile))
        {
            // Load invoice JRXML template.
            final JasperReport report = loadTemplate();

            // Fill parameters map.
            final Map<String, Object> parameters = parameters(order, locale);

            // Create an empty datasource.
            final JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Collections.singletonList("Invoice"));

            // Render the invoice as a PDF file.
            JasperReportsUtils.renderAsPdf(report, parameters, dataSource, pos);

            // return file.
            return pdfFile;
        }
        catch (final Exception e)
        {
             throw new RuntimeException(e);
        }
    }

    // Fill template order params
    private Map<String, Object> parameters(OrderModel order, Locale locale) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("logo", getClass().getResourceAsStream(logo_path));
        parameters.put("order",  order);
        parameters.put("REPORT_LOCALE", locale);
        return parameters;
    }

    // Load invoice JRXML template
    private JasperReport loadTemplate() throws JRException {

 
        final InputStream reportInputStream = getClass().getResourceAsStream(invoice_template);
        final JasperDesign jasperDesign = JRXmlLoader.load(reportInputStream);

        return JasperCompileManager.compileReport(jasperDesign);
    }

    @Override
    public ResponseDto addInvoice(InvoiceDto invoiceDto){

        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),"Transaction Fail");

        try{
            Product product = productDao.getOne(invoiceDto.getProduct());

            Invoice invoice = InvoiceDtoToEntityMapper.getInvoiceEntity(invoiceDto,new Invoice(),product);
            invoiceDao.save(invoice);
            responseDto.setCode(ResponseEnum.SUCCESS.getCode());
            responseDto.setMessage("Invoice Completed");
            return responseDto;
        }catch(Exception e){
            return responseDto;


        }



    }


    @Override
    public List<Invoice> fetchInvoice(){return invoiceDao.findAll();}




}
