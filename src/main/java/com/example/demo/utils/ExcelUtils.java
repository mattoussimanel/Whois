package com.example.demo.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.ClientHistorique;





public class ExcelUtils {
//On définit une fonction parseExcelFile pour lire un fichier Excel et retourner une liste de données Client
public static String EXCELTYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	
	public static ByteArrayInputStream customersToExcel(List<ClientHistorique> clientshisto) throws IOException {
		String[] COLUMNs = { "Nom","Telephone", "Cin", "Acct_status_type","Acctsessiontime", "Framed_ip_address","Tel_adsl","Id" };
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			CreationHelper createHelper = workbook.getCreationHelper();
	
			Sheet sheet = workbook.createSheet("Customers");
	
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());
	
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);
	
			// Row for Header
			Row headerRow = sheet.createRow(0);
	
			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}
	
			// CellStyle for Age
			CellStyle ageCellStyle = workbook.createCellStyle();
			ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));
	
			int rowIdx = 1;
			for (ClientHistorique clienthistorique : clientshisto) {
				Row row = sheet.createRow(rowIdx++);
				row.createCell(0).setCellValue(clienthistorique.getNom());
				row.createCell(1).setCellValue(clienthistorique.getTelephone());
				row.createCell(2).setCellValue(clienthistorique.getCin());
				
				row.createCell(3).setCellValue(clienthistorique.getAcctstatustype());
				row.createCell(4).setCellValue(clienthistorique.getAcctsessiontime());
				row.createCell(5).setCellValue(clienthistorique.getFramedipaddress());
				
				
				Cell ageCell = row.createCell(6);
				ageCell.setCellValue(clienthistorique.getTel_adsl());
				ageCell.setCellStyle(ageCellStyle);
				row.createCell(7).setCellValue(clienthistorique.getId());
			//	row.createCell(7).setCellValue(clienthistorique.getAcctstarttime());
				//row.createCell(8).setCellValue(clienthistorique.getAcctstoptime());
				
				
				
			}
	
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}

	public static List<ClientHistorique> parseExcelFile(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);
	
			Sheet sheet = workbook.getSheet("Clienthisto");
			Iterator<Row> rows = sheet.iterator();
	
			List<ClientHistorique> lstClienthistos = new ArrayList<ClientHistorique>();
	
			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();
	
				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}
	
				Iterator<Cell> cellsInRow = currentRow.iterator();
	
				ClientHistorique cust = new ClientHistorique();
	
				int cellIndex = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();
	
					if (cellIndex == 0) { // ID
						cust.setId((int) currentCell.getNumericCellValue());
					} else if (cellIndex == 1) { // Name
						cust.setAcctstatustype(currentCell.getStringCellValue());
					} else if (cellIndex == 2) { // Address
						cust.setCin(currentCell.getStringCellValue());
					} else if (cellIndex == 3) { // Address
						cust.setFramedipaddress(currentCell.getStringCellValue());
					} else if (cellIndex == 4) { // Address
						cust.setNom(currentCell.getStringCellValue());
					
					
					
					} else if (cellIndex == 5) { // Age
						cust.setAcctsessiontime((int) currentCell.getNumericCellValue());
					} else if (cellIndex == 6) { // Age
						cust.setTel_adsl((int) currentCell.getNumericCellValue());
					} else if (cellIndex == 7) { // Age
						cust.setTelephone((int) currentCell.getNumericCellValue());
					
					}
	
					cellIndex++;
				}
	
				lstClienthistos.add(cust);
			}
	
			// Close WorkBook
			workbook.close();
	
			return lstClienthistos;
		} catch (IOException e) {
			throw new RuntimeException("FAIL! -> message = " + e.getMessage());
		}
	}
	
	public static boolean isExcelFile(MultipartFile file) {
		
		if(!EXCELTYPE.equals(file.getContentType())) {
			return false;
		}
		
		return true;
	}
	
}
