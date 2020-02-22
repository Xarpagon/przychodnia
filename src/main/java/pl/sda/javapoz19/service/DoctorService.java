package pl.sda.javapoz19.service;

import org.springframework.stereotype.Service;
import pl.sda.javapoz19.exceptions.DuplicatedUserNameException;
import pl.sda.javapoz19.model.Doctor;

import pl.sda.javapoz19.repository.DoctorRepository;

import java.util.List;


@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> showAllDoctorsByLastName(String lastName){
        return doctorRepository.findDoctorsByLastName(lastName);
    }

    public Long addDoctor(Doctor doctor){

        doctorRepository.findAll().stream()
                .filter(presentDoctor -> presentDoctor.getUsername().equalsIgnoreCase(doctor.getUsername()))
                .findAny()
                .ifPresent(doctor1 -> throwDuplicatedUserNameException(doctor1.getUsername()));

        doctorRepository.save(doctor);
        return doctor.getId();

    }

    private void throwDuplicatedUserNameException(String username) {
        throw new DuplicatedUserNameException("User " + username + "already exists.");
    }

   /* public List<Doctor> showDoctorsWithSpecialization(String specialization){

            return doctorRepository.findAll().stream()
                    .filter(doctor -> doctor.getSpecialization().getName().equalsIgnoreCase(specialization))
                    .collect(Collectors.toList());

    }

    public List<Doctor> showAllDoctorsBySpecialization(Specialization specialization){


        return doctorRepository.findDoctorsBySpecialization(specialization);
    }*/







}
