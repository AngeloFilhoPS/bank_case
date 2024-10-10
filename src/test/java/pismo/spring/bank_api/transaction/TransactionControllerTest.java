package pismo.spring.bank_api.transaction;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("POST /v1/transactions - Sucesso ao criar uma nova transação")
    public void testCreateTransactionSuccess() throws Exception {
        TransactionCreateRequestDTO requestDTO = new TransactionCreateRequestDTO();
        requestDTO.setAccountId(1L);
        requestDTO.setOperationTypeId(4L);
        requestDTO.setAmount(new BigDecimal("200.0"));

        TransactionResponseDTO responseDTO = new TransactionResponseDTO();
        responseDTO.setAccountId(requestDTO.getAccountId());
        responseDTO.setOperationTypeId(requestDTO.getOperationTypeId());
        responseDTO.setAmount(requestDTO.getAmount());

        Mockito.<ResponseEntity<?>>when(transactionService.createTransaction(any(TransactionCreateRequestDTO.class)))
                .thenReturn(ResponseEntity.status(201).body(responseDTO));

        mockMvc.perform(post("/v1/transactions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.transaction_id").value(responseDTO.getTransactionId()))
                .andExpect(jsonPath("$.account_id").value(responseDTO.getAccountId()))
                .andExpect(jsonPath("$.operationType_id").value(responseDTO.getOperationTypeId()))
                .andExpect(jsonPath("$.amount").value(responseDTO.getAmount()));
    }

}