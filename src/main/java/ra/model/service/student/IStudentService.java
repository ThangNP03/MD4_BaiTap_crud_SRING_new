package ra.model.service.student;

import ra.model.entity.Students;
import ra.model.service.IService;

import java.util.List;

public interface IStudentService extends IService<Students, Integer> {
    List<Students> findByName(String name);
}
