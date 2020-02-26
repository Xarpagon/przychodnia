package pl.sda.javapoz19.service;

import org.springframework.stereotype.Service;
import pl.sda.javapoz19.exception.DuplicatedUserNameException;
import pl.sda.javapoz19.model.Doctor;

import pl.sda.javapoz19.model.Specialization;
import pl.sda.javapoz19.repository.DoctorRepository;

import java.util.List;
import java.util.stream.Collectors;


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
                .filter(presentDoctor -> presentDoctor.getPesel().equals(doctor.getPesel()))
                .findAny()
                .ifPresent(doctor1 -> throwDuplicatedUserNameException(doctor1.getPesel()));

        doctorRepository.save(doctor);

        return doctor.getId();

    }

    private void throwDuplicatedUserNameException(String username) {
        throw new DuplicatedUserNameException("User " + username + "already exists.");
    }

    public void updateDoctor(Doctor doctor){

        Doctor doctorToUpdate = doctorRepository.findDoctorByPesel(doctor.getPesel());

        doctorRepository.delete(doctorToUpdate);
         doctorRepository.save(doctor);
    }

    public void deleteDoctor(String lastName){

        doctorRepository.deleteDoctorByLastName(lastName);
    }

   public List<Doctor> showDoctorsWithSpecialization(Specialization specialization){


        return doctorRepository.findDoctorsBySpecialization(specialization);

    }









}
