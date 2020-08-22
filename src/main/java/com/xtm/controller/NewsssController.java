package com.xtm.controller;


import com.xtm.model.News;
import com.xtm.service.NewsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class NewsssController {

    //注入ArticleServer
    @Resource
    private NewsService newsService;

    @RequestMapping("/pager")
    public List<News> sortPagerArticle(@RequestParam(defaultValue = "1",value = "pageIndex")int pageIndex){
        //指定排序参数对象：根据id，进行降序查询
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        /**
         * 封装分页实体
         * 参数1：pageIndex表示当前查询的是第几页(默认从0开始，0表示第一页)
         * 参数2：表示每页展示多少数据，现在设置每页展示2条数据
         * 参数3：封装排序对象，根据该对象的参数指定根据id降序查询
         */
        Pageable page = PageRequest.of(pageIndex - 1, 2, sort);
        //分页查询
        Page<News> articleDatas = newsService.findAll(page);
        System.out.println("查询总页数："+articleDatas.getTotalPages());
        System.out.println("查询总记录数："+articleDatas.getTotalElements());
        System.out.println("查询当前第几页："+articleDatas.getNumber()+1);
        System.out.println("查询当前页面的记录数："+articleDatas.getNumberOfElements());
        //查询出的结果数据集合
        List<News> articles = articleDatas.getContent();
        System.out.println("查询当前页面的集合："+articles);
        return articles;
    }

    @GetMapping("/pager2")
    public String sortPagerArticle2(Model model,@RequestParam(value = "pageIndex", required = true, defaultValue = "1")Integer pageIndex){
        //指定排序参数对象：根据id，进行降序查询
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        /**
         * 封装分页实体
         * 参数1：pageIndex表示当前查询的是第几页(默认从0开始，0表示第一页)
         * 参数2：表示每页展示多少数据，现在设置每页展示2条数据
         * 参数3：封装排序对象，根据该对象的参数指定根据id降序查询
         */
        Pageable page = PageRequest.of(pageIndex - 1, 2 ,sort);
        //分页查询
        Page<News> articleDatas = newsService.findAll2(page);

        System.out.println(pageIndex);
        System.out.println("查询总页数："+articleDatas.getTotalPages());
        System.out.println("查询总记录数："+articleDatas.getTotalElements());
        System.out.println("查询当前第几页："+articleDatas.getNumber());
        System.out.println("查询当前页面的记录数："+articleDatas.getNumberOfElements());
        //查询出的结果数据集合
        List<News> articles = articleDatas.getContent();
        System.out.println("查询当前页面的集合："+articles);
        model.addAttribute("content",articles);
        model.addAttribute("totalPages",articleDatas.getTotalPages());
        model.addAttribute("currentPage",pageIndex);
        return "index";
    }

    @RequestMapping("/pager3")
    public ModelAndView sortPagerArticle3(@RequestParam(value = "start", defaultValue = "0") Integer start,
                                          @RequestParam(value = "limit", defaultValue = "5") Integer limit){
//        Integer year = Calendar.getInstance().get(Calendar.YEAR);
//        Integer djq = Calendar.getInstance().get(Calendar.MONTH)+1;

//        QkInfo qkInfo = qkInfoRepository.findByYearAndDjq(year,djq);
        //    List<Article> list = articleService.findAllArticles(year,month);
        start = start < 0 ? 0 : start;
        //PageRequest pageRequest = new PageRequest(0,2);
        //Sort sort = new Sort(Sort.DEFAULT_DIRECTION, "id");
        Pageable pageable = PageRequest.of(start, limit);
        Page<News> page= newsService.findAll2(pageable);
/*
        System.out.println(list.getNumber());
       System.out.println(list.getNumberOfElements());
       System.out.println(list.getSize());
       System.out.println(list.getTotalElements());
        System.out.println(list.getTotalPages());
       System.out.println(list.isFirst());
      System.out.println(list.isLast());*/
        System.out.println(page.hasNext()+"============================================================");
        System.out.println(page);
        page.nextPageable();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("page", page);
        mav.addObject("shang","上一期");
        mav.addObject("xia","");
        return mav;
    }

    @RequestMapping("/showPageStudent")
    public String showPageStudent(Model model, int page, int totalPage) {
        System.out.println(totalPage);
        if (page == -1) {
            page++;
        }
        if (page == totalPage) {
            page--;
        }
        // 指定排序参数对象：根据id，进行降序查询
        //Sort sort = new Sort(Sort.Direction.DESC, "id");
        /**
         * 封装分页实体 参数一：pageIndex表示当前查询的第几页(默认从0开始，0表示第一页) 参数二：表示每页展示多少数据，现在设置每页展示2条数据
         * 参数三：封装排序对象，根据该对象的参数指定根据id降序查询
         */
        Pageable pageable = new PageRequest(page, 10);
        Page<News> articleDatas = newsService.findAll2(pageable);
        System.out.println("查询总页数:" + articleDatas.getTotalPages());
        System.out.println("查询总记录数:" + articleDatas.getTotalElements());
        System.out.println("查询当前第几页:" + articleDatas.getNumber() + 1);
        System.out.println("查询当前页面的记录数:" + articleDatas.getNumberOfElements());

        // 查询出的结果数据集合
        List<News> articles = articleDatas.getContent();
        System.out.println("查询当前页面的集合:" + articles);
        model.addAttribute("list", articles);
        model.addAttribute("TotalPages", articleDatas.getTotalPages());
        model.addAttribute("TotalElements", articleDatas.getTotalElements());
        model.addAttribute("Numbe", articleDatas.getNumber() + 1);
        model.addAttribute("NumberOfElements", articleDatas.getNumberOfElements());
        model.addAttribute("temp", page);
        return "index";
    }
}
