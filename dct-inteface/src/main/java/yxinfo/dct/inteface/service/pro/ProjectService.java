package yxinfo.dct.inteface.service.pro;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.pro.ProjectDTO;

import java.util.List;

/**
 * Created by sxd on 2016/7/14.
 */
public interface ProjectService {

    /**
     * 根据查询条件查询项目分页列表
     * @param pageDTO
     * @return
     */
    PageDTO<List<ProjectDTO>> getProjectPageList(PageDTO<ProjectDTO> pageDTO);

    /**
     * 查询本周的项目
     * @param pageDTO
     * @return
     */
    PageDTO<List<ProjectDTO>> getWeekOfProjectPageList(PageDTO<ProjectDTO> pageDTO);

    /**
     * 根据id查询项目
     * @param proId
     * @return
     */
    ProjectDTO getProjectById(Integer proId);

    /**
     * 项目分页列表(后台调用)
     * @param pageDTO
     * @return
     */
    PageDTO<List<ProjectDTO>> getProjectBackendPageList(PageDTO<ProjectDTO> pageDTO);

    int addProject(ProjectDTO projectDTO);

    int updateProject(ProjectDTO projectDTO);

    /**
     * 获取项目list
     * @param projectDTO
     * @return
     */
    List<ProjectDTO> getProjectList(ProjectDTO projectDTO);
}
