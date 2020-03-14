package com.dev.controllers;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.dev.form.UploadItem;

@Controller
@RequestMapping(value = "/uploadfile")
public class UploadFileController {
	private String uploadFolderPath;
	ServletConfig config;

	public String getUploadFolderPath() {
		return uploadFolderPath;
	}

	public void setUploadFolderPath(String uploadFolderPath) {
		this.uploadFolderPath = uploadFolderPath;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getUploadForm(Model model) {
		model.addAttribute(new UploadItem());
		return "/uploadfile";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(UploadItem uploadItem, BindingResult result,HttpSession session) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.err.println("Error: " + error.getCode() + " - "	+ error.getDefaultMessage());
			}
			return "/uploadfile";
		}

		// Some type of file processing...
		System.err.println("------------------File upload process started-------------------------");
		try {
			MultipartFile file = uploadItem.getFileData();
			String fileName = null;
			InputStream inputStream = null;
			OutputStream outputStream = null;
			if (file.getSize() > 0) {
				inputStream = file.getInputStream();
				if (file.getSize() > 10000) {
					System.out.println("File Size:::" + file.getSize());
					//return "/uploadfile";
				}
				System.out.println("size::" + file.getSize());
				fileName = "E:" + "/images/" + file.getOriginalFilename();
				outputStream = new FileOutputStream(fileName);
				System.out.println(fileName);
				System.out.println("fileName:" + file.getOriginalFilename());

				int readBytes = 0;
				byte[] buffer = new byte[10000];
				while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
					outputStream.write(buffer, 0, readBytes);
				}
				outputStream.close();
				inputStream.close();
			}

			// ..........................................
			session.setAttribute("uploadFile", fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/forms/uploadfileindex";
	}

}
