form Box1HouseOwning {
hasSoldHouse: "Did you sell a house in 2010?" boolean
hasBoughtHouse: "Did you by a house in 2010?" boolean
hasMaintLoan: "Did you enter a loan for maintenance/reconstruction?" boolean
//HELLOHHHH
if (privateDebt && valueResidue) {
	sellingPrice: "Price the house was sold for:" integer
	if(level2){
		reallyAddicted: "Private debts for the sold house:" integer(notsomuch) 
	}
	notsomuch: "Private debts for the sold house:" integer (reallyAddicted)
}
if(sellingPrice){
privateDebt: "Private debts for the sold house:" integer 
valueResidue: "Value residue:" integer
}
valueResidue: "Value residue:" integer(sellingPrice - privateDebt)

}