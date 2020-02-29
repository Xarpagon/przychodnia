package pl.sda.javapoz19.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.javapoz19.exception.DuplicatedUserNameException;
import pl.sda.javapoz19.model.Doctor;

import pl.sda.javapoz19.model.Specialization;
import pl.sda.javapoz19.repository.DoctorRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> showAllDoctorsByLastName(String lastName){
        return doctorRepository.findDoctorsByLastName(lastName);
    }

    public Doctor showDoctorByPesel(String pesel){
        return doctorRepository.findDoctorByPesel(pesel);
    }

    public List<Doctor> showDoctorsWithSpecialization(Specialization specialization){

        return doctorRepository.findDoctorsBySpecialization(specialization);

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

    public Doctor updateDoctorDetails(Doctor doctor){

        Doctor doctorToUpdate = doctorRepository.findDoctorByPesel(doctor.getPesel());

        doctorRepository.deleteDoctorByPesel(doctorToUpdate.getPesel());
         doctorRepository.save(doctor);

         return doctor;
    }

    public void deleteDoctor(String lastName){

        doctorRepository.deleteDoctorByPesel(lastName);
    }











}
