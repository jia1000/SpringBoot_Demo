package com.example.demo.controler.admin;

import com.example.demo.dao.blog.Table_dw_ai_taskMapper;
import com.example.demo.entity.blog.Table_dw_ai_task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/deepwise")
public class DwAiTaskController {
    @Autowired
    private Table_dw_ai_taskMapper table_dw_ai_taskMapper;


    @RequestMapping("/ai_tasks")
    public String showAllAITask(Model model) throws Exception {
        List<Table_dw_ai_task> tasks = table_dw_ai_taskMapper.getLists();

        model.addAttribute("headtext", "AI tasks:");
        model.addAttribute("tasks", tasks);

        return "dw_ai_task_thymeleaf";
    }

    @RequestMapping("delete/{id}")
    public String deleteTaskById(@PathVariable Integer id) throws Exception{
        table_dw_ai_taskMapper.deleteByPrimaryKey(id);
        return "delete task id :" + id;
    }

}
