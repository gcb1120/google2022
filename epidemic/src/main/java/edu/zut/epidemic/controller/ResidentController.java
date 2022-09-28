package edu.zut.epidemic.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.zut.epidemic.common.Result;
import edu.zut.epidemic.entity.Resident;
import edu.zut.epidemic.service.IResidentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制层
 * </p>
 *
 * @author roydon
 * @since 2022-09-28
 */
@Slf4j
@RestController
@RequestMapping("/resident")
public class ResidentController {

    @Resource
    private IResidentService residentService;

    /**
     * 新增或者更新
     *
     * @param resident 居民实体
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Resident resident) {

        //密码password进行md5加密处理
        resident.setPassword(DigestUtils.md5DigestAsHex(resident.getPassword().getBytes()));
        return Result.success(residentService.saveOrUpdate(resident));
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(residentService.removeById(id));
    }

    /**
     * 批量删除
     *
     * @param ids id集合
     * @return
     */
    @DeleteMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        return Result.success(residentService.removeByIds(ids));
    }

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping
    public Result findAll() {
        return Result.success(residentService.list());
    }

    /**
     * 根据id查询一条数据
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(residentService.getById(id));
    }

    /**
     * mp分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param name     姓名
     * @param phone    手机号
     * @param idNumber 身份证
     * @return
     */
    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String name,
                           @RequestParam(defaultValue = "") String phone,
                           @RequestParam(defaultValue = "") String idNumber) {
        log.info("当前页码：{}，分页大小：{}", pageNum, pageSize);
        LambdaQueryWrapper<Resident> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Strings.isNotEmpty(name), Resident::getName, name);
        queryWrapper.like(Strings.isNotEmpty(phone), Resident::getPhone, phone);
        queryWrapper.like(Strings.isNotEmpty(idNumber), Resident::getIdNumber, idNumber);
        queryWrapper.orderByDesc(Resident::getUpdateTime);
        return Result.success(residentService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }
}

