package pl._zajecia.UTIL;

import org.springframework.data.jpa.repository.JpaRepository;

import pl._zajecia.z27marca.*;

public class REG_REPO {}



interface repocostam extends JpaRepository<costam, Long>{}
interface repomodelik extends JpaRepository<modelik, Long>{}
interface repotyp extends JpaRepository<typ, Long>{}