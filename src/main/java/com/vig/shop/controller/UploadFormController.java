package com.vig.shop.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import com.vig.shop.model.UploadForm;

@Controller

@RequestMapping(value = "/FileUploadForm")

public class UploadFormController {

	@RequestMapping(method = RequestMethod.GET)

	public String showForm(ModelMap model) {

		UploadForm form = new UploadForm();

		model.addAttribute("FORM", form);

		return "FileUploadForm";

	}

	@RequestMapping(method = RequestMethod.POST)

	public String processForm(@ModelAttribute(value = "FORM") UploadForm form, BindingResult result, ModelMap map) {

		if (!result.hasErrors()) {

			FileOutputStream outputStream = null;

			String filePath = System.getProperty("java.io.tmpdir") + "/" + form.getFile().getOriginalFilename();
			String s= form.getFile().getOriginalFilename();

			try {

				outputStream = new FileOutputStream(new File(filePath));

				outputStream.write(form.getFile().getFileItem().get());
				map.addAttribute("fileName",s);

				outputStream.close();

			} catch (Exception e) {

				System.out.println("Error while saving file");

				return "FileUploadForm";

			}
			

			return "fileuploadsuccess";

		} else {

			return "FileUploadForm";

		}

	}

	public ModelAndView resolveException(HttpServletRequest arg0,

			HttpServletResponse arg1, Object arg2, Exception exception) {

		Map<Object, Object> model = new HashMap<Object, Object>();

		if (exception instanceof MaxUploadSizeExceededException) {

			model.put("errors", "File size should be less then " +

					((MaxUploadSizeExceededException) exception).getMaxUploadSize() + " byte.");

		} else {

			model.put("errors", "Unexpected error: " + exception.getMessage());

		}

		model.put("FORM", new UploadForm());

		return new ModelAndView("/FileUploadForm", (Map) model);

	}

}
