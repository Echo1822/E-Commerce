package com.example.controller;

import com.example.common.Result;
import com.example.entity.Comment;
import com.example.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    // 新增评论
    @PostMapping("/add")
    public Result add(@RequestBody Comment comment) {
        commentService.add(comment);
        return Result.success();
    }

    // 删除评论
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        commentService.deleteById(id);
        return Result.success();
    }

    // 批量删除评论
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        commentService.deleteBatch(ids);
        return Result.success();
    }

    // 更新评论信息
    @PutMapping("/update")
    public Result updateById(@RequestBody Comment comment) {
        commentService.updateById(comment);
        return Result.success();
    }

    // 查询特定评论
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Comment comment = commentService.selectById(id);
        return Result.success(comment);
    }

    // 查询特定商品评论
    @GetMapping("/selectByGoodsId")
    public Result selectByGoodsId(@RequestParam Integer id) {
        List<Comment> list =  commentService.selectByGoodsId(id);
        return Result.success(list);
    }

    // 查询所有评论
    @GetMapping("/selectAll")
    public Result selectAll(Comment comment ) {
        List<Comment> list = commentService.selectAll(comment);
        return Result.success(list);
    }

    // 分页查询
    @GetMapping("/selectPage")
    public Result selectPage(Comment comment, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Comment> page = commentService.selectPage(comment, pageNum, pageSize);
        return Result.success(page);
    }
}
