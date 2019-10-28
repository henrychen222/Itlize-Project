package manage.backendjava.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import manage.backendjava.entities.ResourceEntity;

@RestController
@RequestMapping("/resource")
public class ResourceController extends BaseController<ResourceEntity> {

}
