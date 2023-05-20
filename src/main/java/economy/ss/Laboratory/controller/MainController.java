package economy.ss.Laboratory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {

    //private final ItemService itemService;

    @GetMapping(value="/")
    public String main(Optional<Integer> page, Model model) {
//        Pageable pageable = PageRequest.of(page.orElse(0), 6);
//        Page<MainItemDto> items = itemService.getMainItemPage(itemSearchDto, pageable);
//        model.addAttribute("items", items);
//        model.addAttribute("itemSearchDto", itemSearchDto);
//        model.addAttribute("maxPage", 5);
        return "index";
    }
}
