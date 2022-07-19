package me.light.controller;

import java.rmi.NotBoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.light.Exception.NotFoundBoardException;
import me.light.model.BoardVO;
import me.light.model.Criteria;
import me.light.model.PageMarker;
import me.light.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	
	private BoardService service;
	
	@Autowired
	@Qualifier("boardServiceImplBB")
	public void setService(BoardService service) {
		this.service = service;
	}


	@GetMapping("/list")
	public String getList(Model model, Criteria criteria) {
		PageMarker pageMarker = new PageMarker(criteria, 412);
		List<BoardVO> readAll = service.readAll(criteria);
		model.addAttribute("pageMarker", pageMarker);
		model.addAttribute("list", readAll);
		
		return "board/list";
	}
	
	@GetMapping("/get")
	public String get(Long bno, Model model) {
		BoardVO read = service.read(bno);
		if(read==null) throw new NotFoundBoardException();
		model.addAttribute("board", service.read(bno));
		return "board/get";
	}
	
	@ExceptionHandler(NotFoundBoardException.class)
	public String notFoundBoard() {
		return "errorPage/notFoundBoard";
	}
	
	@GetMapping("/register")
	public String registerForm() {
		return "board/register";
	}
	
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		service.register(vo);
		System.out.println(vo);
		rttr.addFlashAttribute("result", "register");
		rttr.addFlashAttribute("bno", vo.getBno());
		return "redirect:list";
	}
	
	@GetMapping("/modify")
	public String modifyForm(Long bno, Model model) {
		BoardVO read = service.read(bno);
		if(read==null) throw new NotFoundBoardException();
		model.addAttribute("board", read);
		return "board/modify";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rttr) {
		service.modify(vo);
		rttr.addFlashAttribute("result", "modify");
		rttr.addFlashAttribute("bno", vo.getBno());
		return "redirect:list";
	}
	
	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		service.remove(bno);
		rttr.addFlashAttribute("result", "remove")
			.addFlashAttribute("bno", bno);
		return "redirect:list";
	}
}