package validation;

import domain.Student;

import java.math.BigInteger;

public class StudentValidator implements Validator<Student> {

    /**
     * Valideaza un student
     * @param entity - studentul pe care il valideaza
     * @throws ValidationException - daca studentul nu e valid
     */
    @Override
    public void validate(Student entity) throws ValidationException {
        try{
            Integer.parseInt(entity.getID());
        } catch (NumberFormatException e) {
            throw new ValidationException("ID should be an integer!");
        }
        BigInteger zero = BigInteger.valueOf(0);
        BigInteger id = new BigInteger(entity.getID());
        BigInteger maxInt = BigInteger.valueOf(Integer.MAX_VALUE);
        if(id.compareTo(maxInt) > 0) {
            throw new ValidationException("ID should be less than maxint!");
        }
        if(id.compareTo(zero) < 0) {
            throw new ValidationException("ID should be positive!");
        }
        if(entity.getID().equals("")){
            throw new ValidationException("Id incorect!");
        }
        if(entity.getID() == null){
            throw new ValidationException("Id incorect!");
        }
        if(entity.getNume() == ""){
            throw new ValidationException("Nume incorect!");
        }
        if(entity.getGrupa() < 0) {
            throw new ValidationException("Grupa incorecta!");
        }
        if(entity.getEmail() == null){
            throw new ValidationException("Email incorect!");
        }
        if(entity.getNume() == null){
            throw new ValidationException("Nume incorect!");
        }
        if(entity.getEmail().equals("")){
            throw new ValidationException("Email incorect!");
        }
    }
}
