import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

import com.rizwan.AlgoCantHelpException;
import com.rizwan.TableGenerator;


public class TableGeneratorTest {
	@Test
	public void returnsTableOfSizeZero() throws AlgoCantHelpException{
		//Given
		TableGenerator tableGenerator = new TableGenerator();
		//When
		int [][] table = tableGenerator.generateTableForNPrimes(0);
		//Then
		Assert.assertThat("empty table should be returned",table.length,is(0));
	}
	
	@Test
	public void returnsTableOfSizeTwo() throws AlgoCantHelpException{
		//Given
		TableGenerator tableGenerator = new TableGenerator();
		//When
		int [][] table = tableGenerator.generateTableForNPrimes(1);
		//Then
		Assert.assertThat("table with size 2 should be returned",table.length,is(2));
		Assert.assertThat("element at [0][0] should be 2 ",table[0][0],is(1));
		Assert.assertThat("element at [0][1] should be 2 ",table[0][1],is(2));
		Assert.assertThat("element at [1][0] should be 2 ",table[1][0],is(2));
		Assert.assertThat("element at [1][1] should be 4 ",table[1][1],is(4));
	}
	
	@Test
	public void primesNumbersAreListedOnFirstRow() throws AlgoCantHelpException{
		//Given
		TableGenerator tableGenerator = new TableGenerator();
		//When
		int [][] table = tableGenerator.generateTableForNPrimes(5);
		//Then
		Assert.assertThat("table with size 5 should be returned",table.length,is(6));
		Assert.assertArrayEquals("First row contains prime numbers with 1 added extra",table[0],new int[]{1,2,3,5,7,11});
	}
	
	@Test
	public void primesNumbersAreListedOnFirstColumn() throws AlgoCantHelpException{
		//Given
		TableGenerator tableGenerator = new TableGenerator();
		//When
		int [][] table = tableGenerator.generateTableForNPrimes(5);
		//Then
		Assert.assertThat("table with size 5 should be returned",table.length,is(6));
		Assert.assertThat("",table[1][0],is(2));
		Assert.assertThat("",table[2][0],is(3));
		Assert.assertThat("",table[3][0],is(5));
		Assert.assertThat("",table[4][0],is(7));
		Assert.assertThat("",table[5][0],is(11));
	}
	
	@Test
	public void diagonalContainsPrimeSquares() throws AlgoCantHelpException{
		//Given
		TableGenerator tableGenerator = new TableGenerator();
		//When
		int [][] table = tableGenerator.generateTableForNPrimes(5);
		//Then
		Assert.assertThat("table with size 5 should be returned",table.length,is(6));
		Assert.assertThat("",table[1][1],is(4));
		Assert.assertThat("",table[2][2],is(9));
		Assert.assertThat("",table[3][3],is(25));
		Assert.assertThat("",table[4][4],is(49));
		Assert.assertThat("",table[5][5],is(121));
	}
	
	@Test(expected=AlgoCantHelpException.class)
	public void emptyTableIsReturnedForLargeInput() throws AlgoCantHelpException{
		//Given
		TableGenerator tableGenerator = new TableGenerator();
		//When
		int [][] table = tableGenerator.generateTableForNPrimes(Integer.MAX_VALUE);
		//Then
		//expected Exception
	}
	
}
