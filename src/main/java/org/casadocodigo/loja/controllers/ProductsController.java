package org.casadocodigo.loja.controllers;

import javax.transaction.Transactional;

import org.casadocodigo.loja.daos.ProductDAO;
import org.casadocodigo.loja.models.BookType;
import org.casadocodigo.loja.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProductsController {

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("products/form");
		modelAndView.addObject("types", BookType.values());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("products/list");
		modelAndView.addObject("products", productDAO.list());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(Product produto, RedirectAttributes redirectAttributes) {
		productDAO.save(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
		return "redirect:produtos";
	}


}
