@Before
public void setUp() {
    ByteArrayInputStream in = new ByteArrayInputStream(testInput.getByte());
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    consoleUI = new ConsoleUI(board, in, new PrintStream(out, true));
}

@Test
public void testPromptMove() {
    int result = consoleUI.promptMove(player1);

    assertEquals(0, result);

    String output = consoleOutput.toString();

    assertTrue(output.contains("What is your move Col: "));
}
