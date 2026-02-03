package med.vol.api.Infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;

@RestControllerAdvice
public class TratadorDeErros {


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratamento404(){
        return ResponseEntity.notFound().build();
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratamento400(MethodArgumentNotValidException ex){
        var errors = ex.getFieldErrors();

        //converte a lista do getFieldErrors para uma lista do dto
        return ResponseEntity.badRequest().body(errors.stream().map(DadosErrosValidacao::new).toList());
    }

    private record DadosErrosValidacao(String campo, String mensagem){
        public DadosErrosValidacao(FieldError fieldError){
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }

    }



}
