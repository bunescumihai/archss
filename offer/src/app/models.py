from sqlalchemy import Column, Integer, BigInteger, String, Float, DateTime, ForeignKey
from sqlalchemy.orm import relationship
from .database import Base

class SupplierProfile(Base):
    __tablename__ = "supplier_profiles"

    id = Column(Integer, primary_key=True)
    supplier_id = Column(BigInteger, nullable=False)  # external service
    company_name = Column(String)
    region = Column(String)
    contact_info = Column(String)

    offers = relationship("Offer", back_populates="supplier_profile")


class Offer(Base):
    __tablename__ = "offers"

    id = Column(Integer, primary_key=True)
    supplier_profile_id = Column(Integer, ForeignKey("supplier_profiles.id"), nullable=False)
    title = Column(String, nullable=False)
    description = Column(String)
    status = Column(String)
    created_at = Column(DateTime)
    valid_until = Column(DateTime)

    supplier_profile = relationship("SupplierProfile", back_populates="offers")
    items = relationship("OfferItem", back_populates="offer", cascade="all, delete-orphan")


class OfferItem(Base):
    __tablename__ = "offer_items"

    id = Column(Integer, primary_key=True)
    offer_id = Column(Integer, ForeignKey("offers.id"), nullable=False)
    product_id = Column(BigInteger)  # external API
    product_name = Column(String)
    available_quantity = Column(Float)
    unit_price = Column(Float)
    unit = Column(String)

    offer = relationship("Offer", back_populates="items")

    @property
    def total_value(self):
        if self.available_quantity and self.unit_price:
            return self.available_quantity * self.unit_price
        return 0.0
