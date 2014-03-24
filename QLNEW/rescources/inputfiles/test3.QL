form Box1HouseOwning {
	valueResidue: "Value residue:" boolean
	valueResidue2: "Value residue:" boolean (value2)
	if(valueResidue || valueResidue2){
		if(false || valueResidue2){
		value2: "is visible:" boolean 
		}
	}else{
		value3: "is visible else: " boolean (false)
	}
	lala: "nbla" boolean
}