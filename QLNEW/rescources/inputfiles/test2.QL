form Box1HouseOwning {
	valueResidue: "Value residue:" boolean
	valueInt: "Value int:" integer
	valueInt2: "Value of prev +1:" integer (valueInt +1)
	if(valueResidue){
		value2: "is visible:" boolean
	}
}