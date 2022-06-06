package service;

import repositories.DemoRepository;
import repositories.MySQLDemoRepository;

public class DemoService {

    private DemoRepository demoRepository = new MySQLDemoRepository();
}
