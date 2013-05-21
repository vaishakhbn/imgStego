package org.developerworks.workflow;

import java.math.BigInteger;
import java.util.Vector;

public class primitiveRoot{
	public boolean isPrimitive(BigInteger m, BigInteger n) {

	    BigInteger bigi, vectorint;
	    Vector<BigInteger> v = new Vector<BigInteger>(m.intValue());
	    int i;

	    for (i=0;i<m.intValue();i++)
	        v.add(new BigInteger("0"));

	    for (i=1;i<m.intValue();i++)
	    {
	        bigi = new BigInteger("" + i);

	        if (m.gcd(bigi).intValue() == 1)
	            v.setElementAt(new BigInteger("1"), n.modPow(bigi,m).intValue());
	    }

	    for (i=0;i<m.intValue();i++)
	    {
	        bigi = new BigInteger("" + i);

	        if (m.gcd(bigi).intValue() == 1)
	        {
	            vectorint = v.elementAt(bigi.intValue());
	            if ( vectorint.intValue() == 0)
	                i = m.intValue() + 1;
	        }
	    }

	    if (i == m.intValue() + 2)
	        return false;
	    else
	        return true;

	}

}