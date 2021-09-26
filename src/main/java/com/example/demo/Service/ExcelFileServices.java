package com.example.demo.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Repository.ClienthistoriqueRepository;
import com.example.demo.entities.ClientHistorique;
import com.example.demo.utils.ExcelUtils;





@Service
public class ExcelFileServices {

	@Autowired
	ClienthistoriqueRepository clienthistoRepository;

	// Store File Data to Database
	public void store(MultipartFile file) {
		try {
			List<ClientHistorique> lstClientshisto = ExcelUtils.parseExcelFile(file.getInputStream());
			// Save Customers to DataBase
			clienthistoRepository.saveAll(lstClientshisto);
		} catch (IOException e) {
			throw new RuntimeException("FAIL! -> message = " + e.getMessage());
		}
	}

	// Load Data to Excel File
	public ByteArrayInputStream loadFile() {
		List<ClientHistorique> clientshisto = (List<ClientHistorique>) clienthistoRepository.findAll();

		try {
			ByteArrayInputStream in = ExcelUtils.customersToExcel(clientshisto);
			return in;
		} catch (IOException e) {}

		return null;
	}
}