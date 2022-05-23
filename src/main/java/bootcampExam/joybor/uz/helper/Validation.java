package bootcampExam.joybor.uz.helper;

import bootcampExam.joybor.uz.dao.*;
import bootcampExam.joybor.uz.dto.ValidatorDTO;


import java.util.ArrayList;
import java.util.List;

public class Validation {


    public static List<ValidatorDTO> errors = new ArrayList<>();

    public static List<ValidatorDTO> validateHotel(Hotel hotel){

        errors.clear();

        if (!StringHelper.isValidField(hotel.getName())){
            errors.add(new ValidatorDTO("name", HttpMessage.EMPTY_FIELD));
        }

        if (!StringHelper.isValidField(hotel.getAddress())){
            errors.add(new ValidatorDTO("address", HttpMessage.EMPTY_FIELD));
        }

        if (!StringHelper.isValidField(hotel.getEmail())){
            errors.add(new ValidatorDTO("email", HttpMessage.EMPTY_FIELD));
        }

        return errors;
    }

    public static List<ValidatorDTO> validateCustomer(Customer customer) {

        errors.clear();

        if (!StringHelper.isValidField(customer.getName())){
            errors.add(new ValidatorDTO("name",HttpMessage.EMPTY_FIELD));
        }

        if (!StringHelper.isValidField(customer.getGender())){
            errors.add(new ValidatorDTO("gender",HttpMessage.EMPTY_FIELD));
        }

        if (!NumberHelper.isCardNumber(customer.getCard_number().intValue())){
            errors.add(new ValidatorDTO("card_number", HttpMessage.NUMBER_FORMAT));
        }

        if (!NumberHelper.isNumberValid(customer.getTel_number().length())){
            errors.add(new ValidatorDTO("Tel_number",HttpMessage.NOT_FOUND));
        }

        return errors;
    }

    public static List<ValidatorDTO> validateReservation(Reservation reservation) {

        errors.clear();

        if (!DataHelper.isValidDate(reservation.getAccess_date().toString())){
            errors.add(new ValidatorDTO("access_date", HttpMessage.DATE_FORMAT_YYYY_MM_DD));
        }

        if (!DataHelper.isValidDate(reservation.getCheckout_date().toString())){
            errors.add(new ValidatorDTO("checkout_date", HttpMessage.DATE_FORMAT_YYYY_MM_DD));
        }

        return errors;
    }

    public static List<ValidatorDTO> validateReview(Review review) {

        errors.clear();

        if (!StringHelper.isValid(review.getTitle())){
            errors.add(new ValidatorDTO("title",HttpMessage.EMPTY_FIELD));
        }

        if (!StringHelper.isValid(review.getComment())){
            errors.add(new ValidatorDTO("comment",HttpMessage.EMPTY_FIELD));
        }

        if (!StringHelper.isValid(review.getRating())){
            errors.add(new ValidatorDTO("rating",HttpMessage.EMPTY_FIELD));
        }

        return errors;
    }

    public static List<ValidatorDTO> validateRoom(Room room) {

        errors.clear();

        if (!StringHelper.isValid(room.getType())){
            errors.add(new ValidatorDTO("type",HttpMessage.EMPTY_FIELD));
        }

        if (!NumberHelper.isNumberValid(room.getPrice().intValue())){
            errors.add(new ValidatorDTO("price",HttpMessage.MINUS_VALUE));
        }

        return errors;
    }
}
