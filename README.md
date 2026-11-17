# Test tasks

The tasks are on the task sheet.

Test classes, under `src/test/java`:

1. `dice/RollTest`
2. `password/PasswordTest`
3. `movienight/VoteServiceMockTest`
4. `movienight/VoteServiceTest`
5. `movienight/VoteServiceWinnerTest`
6. `movienight/VoteControllerTest` and `movienight/MovieNightEndToEndTest`

Tasks 4 to 6 start Spring. The first run takes a few seconds.

## Examples from the slides

Unit test:

```java
@Test
void totalIsPriceTimesQuantity() {
    Order order = new Order(20, 3);      // arrange
    int total = order.total();           // act
    assertEquals(60, total);             // assert
}
```

Exception:

```java
@Test
void anOrderCannotHaveANegativeQuantity() {
    assertThrows(IllegalArgumentException.class,
            () -> new Order(20, -3));
}
```

Mock:

```java
@Test
void anOrderForAnUnknownCustomerIsRejected() {
    when(customerRepository.findById(7L))
            .thenReturn(Optional.empty());

    assertThrows(IllegalArgumentException.class,
            () -> orderService.placeOrder(7L, 20, 3));
}
```

Database:

```java
@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @BeforeEach
    void setUp() {
        customer = customerRepository.save(new Customer("Sara"));
    }
```

Controller:

```java
@Test
void anUnknownOrderAnswers404() throws Exception {
    when(orderService.find(7L)).thenReturn(Optional.empty());

    mockMvc.perform(get("/orders/7"))
            .andExpect(status().isNotFound());
}
```

End to end:

```java
@Test
void anOrderPlacedThroughTheApiIsStored() throws Exception {
    mockMvc.perform(post("/customers/{id}/orders", customer.getId())
                    .param("price", "20").param("quantity", "3"))
            .andExpect(status().isCreated());

    assertEquals(1, orderRepository.count());
}
```
