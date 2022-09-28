package edu.zut.epidemic.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.zut.epidemic.common.Result;
import edu.zut.epidemic.entity.Resident;
import edu.zut.epidemic.entity.dto.ResidentDTO;
import edu.zut.epidemic.service.IResidentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
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
     * 居民注册接口
     *
     * @param residentDTO 安全实体
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody ResidentDTO residentDTO) {

        residentDTO.setUpdateTime(LocalDateTime.now());
        residentDTO.setPassword(DigestUtils.md5DigestAsHex(residentDTO.getPassword().getBytes()));

        return Result.success(residentService.register(residentDTO));
    }


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
     * @param pageNum  当前页码
     * @param pageSize 每页数据条数
     * @param name     姓名
     * @param phone    手机号
     * @param idNumber 身份证
     * @param age      年龄
     * @return Result
     */
    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String name,
                           @RequestParam(defaultValue = "") String phone,
                           @RequestParam(defaultValue = "") String idNumber,
                           @RequestParam(defaultValue = "") Integer age) {

        IPage<Resident> page = new Page<>(pageNum, pageSize);

        LambdaQueryWrapper<Resident> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Strings.isNotEmpty(name), Resident::getName, name);
        queryWrapper.like(Strings.isNotEmpty(phone), Resident::getPhone, phone);
        queryWrapper.like(Strings.isNotEmpty(idNumber), Resident::getIdNumber, idNumber);
        // 筛选大于age的list
        queryWrapper.ge(Strings.isNotEmpty(Integer.toString(age)), Resident::getAge, age);
        queryWrapper.orderByDesc(Resident::getUpdateTime);

        IPage<Resident> residentIPage = residentService.page(page, queryWrapper);
        log.info("当前页码：{}，分页大小：{}，数据条数：{},数据总页数：{}", pageNum, pageSize, page.getTotal(), page.getPages());
        return Result.success(residentIPage);

    }

    /**
     * 通过年龄筛选居民
     *
     * @param age 年龄
     * @return
     */
    @GetMapping("/get/{age}")
    public Result getAllByAge(@PathVariable Integer age) {

        LambdaQueryWrapper<Resident> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ge(Resident::getAge, age);
        queryWrapper.orderByDesc(Resident::getAge);

        return Result.success(residentService.list(queryWrapper));

    }


}

