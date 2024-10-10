package pismo.spring.bank_api.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("POST /v1/accounts - Sucesso ao criar uma nova conta")
    public void testCreateAccountSuccess() throws Exception {

        AccountCreateRequestDTO requestDTO = new AccountCreateRequestDTO();
        requestDTO.setDocumentNumber("12345678900");

        AccountResponseDTO responseDTO = new AccountResponseDTO(1L, "12345678900");

        Mockito.when(accountService.createAccountByDocument(any(AccountCreateRequestDTO.class)))
                .thenReturn(responseDTO);

        mockMvc.perform(post("/v1/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.account_id").value(responseDTO.getAccount_id()))
                .andExpect(jsonPath("$.document_number").value(responseDTO.getDocument_number()));
    }

    @Test
    @DisplayName("GET /v1/accounts/{id} - Sucesso ao obter uma conta existente")
    public void testGetAccountByIdSuccess() throws Exception {
        Long accountId = 1L;
        AccountResponseDTO responseDTO = new AccountResponseDTO(accountId, "12345678900");

        Mockito.when(accountService.getAccountById(eq(accountId)))
                .thenReturn(Optional.of(responseDTO));

        mockMvc.perform(get("/v1/accounts/{id}", accountId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.account_id").value(responseDTO.getAccount_id()))
                .andExpect(jsonPath("$.document_number").value(responseDTO.getDocument_number()));
    }
}