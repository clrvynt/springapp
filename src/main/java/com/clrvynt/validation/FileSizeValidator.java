package com.clrvynt.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

public class FileSizeValidator implements ConstraintValidator<FileSize, MultipartFile> {

    private long fileSizeValue;

    @Override
    public void initialize(FileSize arg0) {
	fileSizeValue = arg0.value();
    }

    @Override
    public boolean isValid(MultipartFile arg0, ConstraintValidatorContext arg1) {
	if (arg0 == null)
	    return true;
	if (arg0.isEmpty())
	    return true;

	try {
	    return (arg0.getBytes().length < fileSizeValue);
	} catch (Exception e) {
	    return false;
	}
    }

}